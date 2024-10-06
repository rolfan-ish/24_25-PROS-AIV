#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

/* Error handling function */
void die(const char *error) {
  perror(error);
  exit(EXIT_FAILURE);
}

/* Checked version of fork */
pid_t sfork(void) {
  pid_t pid = fork();
  if (pid < 0)
    die("fork");
  return pid;
}

/* Prints the expected message for this process */
void print(int number, int parent) {
  printf("Yo soy el hijo %i, mi padre es PID= %i, yo soy PID= %i\n", number, parent, (int)getpid());
}

int main(void) {
  pid_t root = getpid();
  pid_t child1 = sfork();
  /* Parent path */
  if (child1) {
    pid_t child2 = sfork();
    /* Child2 path */
    if (child2) {
      print(2, root);

      pid_t child3 = sfork();
      if (!child3) {
	/* Child3 path */
	print(3, child2);
      } else {
	wait(NULL);
      }
    }
  } else {
    /* Child1 path */
    print(1, root);
  }
}
