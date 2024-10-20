#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>

void die(const char *msg) {
  perror(msg);
  exit(EXIT_FAILURE);
}

pid_t spawn_pipe(int fd[static 2]) {
  if (pipe(fd) < 0)
    die("pipe");
  pid_t pid = fork();
  if (pid < 0)
    die("fork");
  return pid;
}

void sendmsg(int pipe[static 2], const char *prefix, const char *from,  const char *to, const char *msg) {
  printf("%sEl %s envia un mensaje al %s.......\n", prefix, from, to);
  write(pipe[1], msg, strlen(msg));
}

void recvmsg(int pipe[static 2], const char *prefix, const char *from) {
  char buffer[BUFSIZ];
  ssize_t len = read(pipe[0], buffer, sizeof buffer - 1);
  buffer[len] = '\0';
  printf("%sEl %s recibe mensage del %s..\n", prefix, from, buffer);
}

int main(int argc, char *argv[]) {
  int abu_pipe[2];
  pid_t abu = spawn_pipe(abu_pipe);
  if (abu) {
    /* Inside abuelo */
    sendmsg(abu_pipe, "", "ABUELO", "HIJO", "abuelo: Saludo del abuelo");
    wait(NULL);
    recvmsg(abu_pipe, "", "ABUELO");
    return 0;
  }

  int hij_pipe[2];
  pid_t hij = spawn_pipe(hij_pipe);
  if (hij) {
    /* Inside hijo */
    recvmsg(abu_pipe, "\t", "HIJO");
    sendmsg(hij_pipe, "\t", "HIJO", "NIETO", "padre: Saludo del padre");
    wait(NULL);
    recvmsg(hij_pipe, "\t", "HIJO");
    sendmsg(abu_pipe, "\t", "HIJO", "ABUELO", "HIJO: Saludo del hijo");
    return 0;
  }
  
  /* Inside nieto */
  recvmsg(hij_pipe, "\t\t", "NIETO");
  sendmsg(hij_pipe, "\t\t", "NIETO", "HIJO", "hijo: Saludo del nieto");
  // pipes are closed by the OS for us
  return 0;
}
