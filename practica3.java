import java.util.Scanner;

public class practica3 {
    


public static void main(String[] args) {
    
Scanner teclado= new Scanner(System.in);


String a = "Java";
String b = new String("Java");
String c = "Ja" + "va";
String d = "Ja";
d += "va";
System.out.println(a == b);
System.out.println(a == c);
System.out.println(a == d);
System.out.println(a.equals(d));
b = b.concat(" 21");
System.out.println(a);
System.out.println(b);

StringBuilder sb = new StringBuilder("ABCDE");
sb.delete(1, 4);
sb.insert(1, "xyz");
sb.reverse();
sb.replace(1, 4, "-");
System.out.println(sb);
System.out.println(sb.length());
System.out.println(sb.capacity());

//Comprension de Caracteres consecutivos
StringBuilder textofinal = new StringBuilder();
String texto = teclado.nextLine();

if (texto==""){
System.out.println("No se ingreso nada");
return;
}

char actexto= texto.charAt(0);
int tamaño= texto.length();
int repetido=1;



for (int i=1; i<tamaño; i++){
if ((texto.charAt(i))==actexto){
repetido=repetido+1;


}
else{

textofinal.append(actexto).append(repetido);
actexto=texto.charAt(i);
repetido=1;
}

}

textofinal.append(actexto).append(repetido);
System.out.println(textofinal.toString());

// Palindromo
boolean espalindromo = true;
String textolimpio = texto.toLowerCase();
textolimpio = textolimpio.replace("á", "a");
textolimpio = textolimpio.replace("é", "e");
textolimpio = textolimpio.replace("í", "i");
textolimpio = textolimpio.replace("ó", "o");
textolimpio = textolimpio.replace("ú", "u");

String caracteresprohibidos = " !#$%&/()={}[]¿?.,¡!''"; 

for (int k = 0; k < caracteresprohibidos.length(); k++){
    String simbolo = String.valueOf(caracteresprohibidos.charAt(k));
    textolimpio = textolimpio.replace(simbolo, "");
}

int tamañolimpio = textolimpio.length();
int mitadtamañolimpio = tamañolimpio / 2;
int indiceFinal = textolimpio.length() - 1;

for (int j = 0; j < mitadtamañolimpio; j++){
if (textolimpio.charAt(j) == textolimpio.charAt(indiceFinal)){
indiceFinal = indiceFinal - 1;
continue;
}
else{
espalindromo = false;
break; 
}
}//for

System.out.println("¿Es palindromo?..." + espalindromo);

//Eliminar Repetidos
StringBuilder noduplicados = new StringBuilder();


for (int i = 0; i < tamaño; i++) {
    
char letraactual = texto.charAt(i);
boolean existe = false;

for (int k = 0; k < noduplicados.length(); k++) {
      
if (noduplicados.charAt(k) == letraactual) {
existe = true; 
break;
}

}

if (existe == false) { 
noduplicados.append(letraactual);
}


}


System.out.println("Texto sin duplicados... " + noduplicados.toString());

//Remplazo manual de subcadenas

System.out.println("¿Que quieres buscar");
String buscar=teclado.toString();
System.out.println("¿Por que lo quieres remplazar?");
String reemplazo =teclado.toString();

StringBuilder resultadoFinal = new StringBuilder();
    
int f=0;
while (f < texto.length()) {
boolean coincidencia = true;

if (f + buscar.length() > texto.length()) {
coincidencia = false;

} 

else {
  
for (int j = 0; j < buscar.length(); j++) {
if (texto.charAt(f + j) != buscar.charAt(j)) {
coincidencia = false;

break; 
}


}
}

if (coincidencia) {
resultadoFinal.append(reemplazo);
f = f + buscar.length(); 
} 

else {
resultadoFinal.append(texto.charAt(f));
f++; 
}
}

System.out.println("Texto resultante: " + resultadoFinal.toString());

//Invertir el orden de las palabras


String textoinvertir =texto;
StringBuilder textoInvertido = new StringBuilder();


int finpalabra = textoinvertir.length();

for (int i = textoinvertir.length() - 1; i >= 0; i--) {

if (textoinvertir.charAt(i) == ' ') {
for (int j = i + 1; j < finpalabra; j++) {
textoInvertido.append(textoinvertir.charAt(j));
}

textoInvertido.append(' ');
finpalabra = i;

}
}

for (int j = 0; j < finpalabra; j++) {
    textoInvertido.append(textoinvertir.charAt(j));
}

System.out.println("Texto invertido: " + textoInvertido.toString());


//Validar delimitadores
System.out.println("Ingrese expresion con algun delimitador");
String delimitadores =teclado.toString();
StringBuilder pila = new StringBuilder();
boolean valido = true;

for (int i = 0; i < delimitadores.length(); i++) {
char letra = delimitadores.charAt(i);
if (letra == '(' || letra == '[' || letra == '{') {
pila.append(letra);
}
else 
if (letra == ')' || letra == ']' || letra == '}') {
if (pila.length() == 0) {
valido = false;
break; 
}

int ultimaPosicion = pila.length() - 1;
char ultimoAbierto = pila.charAt(ultimaPosicion);

if ((letra == ')' && ultimoAbierto == '(') || (letra == ']' && ultimoAbierto == '[') ||(letra == '}' && ultimoAbierto == '{')) {
            pila.deleteCharAt(ultimaPosicion);
} 
else {

valido = false;
break;
}
}
}

if (pila.length() > 0) {
valido = false; // Si quedaron símbolos abiertos sin cerrar, es inválido
}

System.out.println("¿Es válida la expresión?... " + valido);



}//Main









}//practica3


