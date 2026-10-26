class EditorTexto {

private StringBuilder contenido;
private StringBuilder anterior;

public EditorTexto() {
this.contenido = new StringBuilder();
this.anterior = null;
    }

private void guardarEstado() {
this.anterior = new StringBuilder(this.contenido.toString());
}

private boolean esRangoValido(int inicio, int fin) {
if (inicio < 0 || fin > contenido.length() || inicio > fin) {

System.out.println("Indices fuera de rango");
return false;
}

return true;

}
public void escribir(String texto) {
if (texto == null || texto.isEmpty()) return;
guardarEstado();
contenido.append(texto);

}

public void insertar(int posicion, String texto) {
if (texto == null || texto.isEmpty()) return;
if (posicion < 0 || posicion > contenido.length()) {
System.out.println("Posición invalida");
return;
}
guardarEstado();

contenido.insert(posicion, texto);

}

public void eliminar(int inicio, int fin) {
if (esRangoValido(inicio, fin)) {
guardarEstado();
contenido.delete(inicio, fin);
}
}

public void reemplazar(int inicio, int fin, String texto) {
if (texto == null) texto = "";
if (esRangoValido(inicio, fin)) {
guardarEstado();
contenido.replace(inicio, fin, texto);

}


}

    public void deshacer() {
        if (anterior == null) {
            System.out.println("No hay nada por deshacer");
            return;
        }
        contenido = new StringBuilder(anterior.toString());
        anterior = null; 
    }

    public String obtenerTexto() {
        return contenido.toString();






    }




}