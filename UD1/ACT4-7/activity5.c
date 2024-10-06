#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

/* Error function */
void die(const char *error) {
  perror(error);
  exit(EXIT_FAILURE);
}

/* Number of processes to spawn */
const int N = 3;

/* Recursive function that spawns N processes */
void spawn_and_wait(int pnum) {
  if (pnum == N)
    return;
  pid_t child = fork();
  if (child < 0)
    die("fork");
  
  if (child) {
    /* Wait for the child to die */
    wait(NULL);
  } else {
    printf("I am child number %i\n", pnum);
    spawn_and_wait(pnum + 1);
  }
}

int main(void) {
  spawn_and_wait(0);
  /* Implicit return 0 */
}
