#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	int fp;
	int p, bytesleidos;
	char buffer[100]; // Larger buffer to read the full message

	// Create FIFO with read and write permissions
	p = mknod("FIFO2", S_IFIFO | 0666, 0);
	if (p == -1) {
		printf("Ha ocurrido un error.... \n"); // Happens if FIFO already exists
		exit(1);
	}

	while (1) {
		// Open FIFO in read-only mode
		fp = open("FIFO2", O_RDONLY);
		if (fp == -1) {
			printf("Error al abrir el FIFO para lectura...\n");
			exit(1);
		}
		printf("Obteniendo información...\n");

		// Read the message from the FIFO
		bytesleidos = read(fp, buffer, sizeof(buffer) - 1);
		if (bytesleidos > 0) {
			buffer[bytesleidos] = '\0'; // Null-terminate the string
			printf("Mensaje recibido: %s", buffer);
		}

		close(fp);
	}

	return 0;
}
