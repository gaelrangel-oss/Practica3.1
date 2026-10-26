import java.util.Scanner;
public class CalculadoraArreglos {


public static void main(String[] args) {
Scanner teclado = new Scanner(System.in);
int opcion = 0;

while (opcion != 3) {
System.out.println("1.-Arreglo de numeros");
System.out.println("2.-Suma binaria");
System.out.println("3.-Salir");
System.out.println("Ingresa opcion");

opcion = teclado.nextInt();
teclado.nextLine();

switch (opcion) {

case 1:
System.out.println("\nEjecutando Arreglo de numeros...");
int[] numeros = {8, 3, 10, 5, 4};

int suma = 0;
int mayor = numeros[0];

for (int numero : numeros) {

suma += numero;

if (numero > mayor) {


mayor = numero;
}

}

double promedio = (double) suma / numeros.length;
System.out.println("suma = " + suma + "; promedio = " + promedio + "; mayor = " + mayor);

break;

case 2:
System.out.println("\nEjecutando Suma binaria...");
System.out.println("Ingrese primera cadena binaria");
String cadenaA = teclado.nextLine();

System.out.println("Ingresa la segunda cadena binaria");
String cadenaB = teclado.nextLine();

char[] arregloA = cadenaA.toCharArray();
char[] arregloB = cadenaB.toCharArray();
int indiceA = arregloA.length - 1;
int indiceB = arregloB.length - 1;
int indiceRes = Math.max(arregloA.length, arregloB.length);
char[] resultado = new char[indiceRes + 1]; 
int acarreo = 0; 

while (indiceA >= 0 || indiceB >= 0 || acarreo > 0) {

int sumaBinaria = acarreo;

if (indiceA >= 0) {

sumaBinaria += arregloA[indiceA] - '0';
indiceA--;

}
if (indiceB >= 0) {
sumaBinaria += arregloB[indiceB] - '0';
indiceB--;


}

resultado[indiceRes] = (char) ((sumaBinaria % 2) + '0'); 
acarreo = sumaBinaria / 2; 
indiceRes--;
}

int inicio = indiceRes + 1;
String sumaFinal = new String(resultado, inicio, resultado.length - inicio);
System.out.println("El resultado de la suma es:" + sumaFinal);
break;

case 3:
System.out.println("au revoir");
break;
default:
System.out.println("Opcion invalida");
break;

}
}
}
}
    
