#include <pthread.h>
#include <stdio.h>
#define MAX 100
void inc_x(int x);
void *metodo(void *inc_X){
    int *x = (int *) inc_X;
    while(++(*x)<MAX);
    printf("Los valores de X y Y una vez incrementados son:\n");
    return NULL;
}
int main () {
pthread_t hilo; //instancia del hilo
int x = 0;
int y = 0;
printf("x: %d, y: %d\n", x, y);
pthread_create(&hilo, NULL, metodo, &x); //Ubicacion del hilo
pthread_join(hilo, NULL); //Join
//inc_x(x);
while(++y< MAX);
//printf("y termino el incremento\n");
printf("X: %d, Y: %d\n", x,y);
return 0;
}
void inc_x (int x){
    printf("Estoy en el metodo implementado\n");
    while(++x < MAX);
    printf("x termino el incremento\n");
    printf("X: %d\n", x);
}