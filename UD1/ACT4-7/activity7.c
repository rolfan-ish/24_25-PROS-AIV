#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
  int var = 6;
  printf("Valor inicial de la variable: %i\n", var);

  pid_t pid = fork();
  if (pid) {
    /* inside parent */
    var += 5;
    wait(NULL);			/* Wait for child to end */
    printf("Variable en el proceso Padre: %i\n", var);
  } else {
    /* inside child */
    var -= 5;
    printf("Variable en el proceso Hijo: %i\n", var);
  }
}
