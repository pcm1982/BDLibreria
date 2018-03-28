package com.example.usuario.bdlibreria;

/**
 * Created by Usuario on 28/03/2018.
 */

public class Libro {

        private int id;
        private String autor;
        private String titulo;
        private double precio;

        public Libro(int id, String autor, String titulo, double precio) {
            this.id = id;
            this.autor = autor;
            this.titulo = titulo;
            this.precio = precio;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Libro libro = (Libro) o;

            if (getId() != libro.getId()) return false;
            if (Double.compare(libro.getPrecio(), getPrecio()) != 0) return false;
            if (getAutor() != null ? !getAutor().equals(libro.getAutor()) : libro.getAutor() != null)
                return false;
            return getTitulo() != null ? getTitulo().equals(libro.getTitulo()) : libro.getTitulo() == null;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = getId();
            result = 31 * result + (getAutor() != null ? getAutor().hashCode() : 0);
            result = 31 * result + (getTitulo() != null ? getTitulo().hashCode() : 0);
            temp = Double.doubleToLongBits(getPrecio());
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "id=" + id +
                    ", autor='" + autor + '\'' +
                    ", titulo='" + titulo + '\'' +
                    ", precio=" + precio +
                    '}';
        }
    }

