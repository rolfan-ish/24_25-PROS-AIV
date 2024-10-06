#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/* Simple function that logs an error and exits the program */
void die(const char *err) {
    perror(err);
    exit(EXIT_FAILURE);
}

int main(void) {
    /* PIDs of all the children */
    pid_t children[3];
    int parent_pid = getpid();
    for (int i = 0; i < 3; ++i) {
        children[i] = fork();
        /* Check that fork didn't fail */
        if (children[i] < 0)
            die("fork");
	/* Children path */
        if (!children[i]) {
           printf("Soy el hijo %i, Mi padre es %i y mi PID es %i\n", i + 1, parent_pid, (int)getpid());
           exit(EXIT_SUCCESS);
        }
    }

    /* Wait for childrens to finish */
    for (int i = 0; i < 3; ++i) {
       wait(NULL);
    }
    printf("Proceso padre %i\n", parent_pid);

    exit(EXIT_SUCCESS);
}
