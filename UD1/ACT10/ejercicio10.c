#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>

void sigusr1_handler(int sig) {
    printf("Padre recove señal %i...\n", sig);
}

int main() {
    pid_t pid;
    struct sigaction sa;

    // Set up the signal handler for SIGUSR1 in the parent
    sa.sa_handler = sigusr1_handler;
    sa.sa_flags = 0;
    sigemptyset(&sa.sa_mask);
    sigaction(SIGUSR1, &sa, NULL);

    // Fork the process
    pid = fork();

    if (pid < 0) {
        perror("fork failed");
        exit(1);
    } else if (pid == 0) {
        // Child process
        for (int i = 0; i < 3; i++) {
            kill(getppid(), SIGUSR1);  // Send SIGUSR1
            sleep(1);  // Sleep for a second
        }

        // Notify about SIGKILL and send SIGKILL to the parent
        printf("Terminado (killed)\n");
        kill(getppid(), SIGKILL);
        exit(0);
    } else {
        // Parent process
        while (1) {
            pause();  // Wait for signals
        }
    }

    return 0;
}
