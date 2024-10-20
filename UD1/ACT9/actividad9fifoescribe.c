#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	int fp;
	char saludo[] = "Un saludo desde actividad9fifoescribe!\n";

	// Open FIFO in write-only mode
	fp = open("FIFO2", O_WRONLY);
	if (fp == -1) {
		printf("Error al abrir el FIFO para escritura...\n");
		exit(1);
	}

	// Send the message to the FIFO
	printf("Mandando información al FIFO...\n");
	write(fp, saludo, sizeof(saludo));

	close(fp);
	return 0;
}
