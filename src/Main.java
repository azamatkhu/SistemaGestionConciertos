import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seccion = -1;
        int opcion = -1;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "RIBERA",
                "ribera"
        )) {
            while(seccion != 0){
                System.out.println("Conectado!");

                System.out.println("--- MENU -----");
                System.out.println("1. Artista");
                System.out.println("2. Concierto");
                System.out.println("3. Entradas");
                System.out.println(" ");
                System.out.println("0. Salir");
                System.out.println("Elige la seccion: ");

                seccion = sc.nextInt();
                sc.nextLine();

                switch(seccion){
                    case 1:
                        System.out.println("1. Añadir artista");
                        System.out.println("2. Eliminar artista");
                        System.out.println("3. Listar artistas");

                        System.out.println("Elige la opcion: ");
                        opcion = sc.nextInt();
                        sc.nextLine();

                        ManejarArtista(sc, opcion, connection);

                        break;
                    case 2:
                        System.out.println("1. Añadir concierto");
                        System.out.println("2. Eliminar concierto ");
                        System.out.println("3. Listar conciertos ");
                        System.out.println("Elige la opcion: ");
                        opcion = sc.nextInt();
                        sc.nextLine();

                        ManejarConcierto(sc, opcion, connection);

                        break;
                    case 3:
                        System.out.println("1. Registrar venta de entrada");
                        System.out.println("2. Listar ventas de entrada ");
                        System.out.println(" ");
                        System.out.println("Elige la opcion: ");
                        opcion = sc.nextInt();
                        sc.nextLine();

                        ManejarEntrada(sc, opcion, connection);

                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No existe esta seccion!");
                        opcion = -1;
                        break;
                }
                seccion = -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ManejarArtista(Scanner sc, int opcion, Connection con){
        List<Artista> lista = new ArrayList<>();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("Escribe el nombre del artista: ");
                    String nombre = sc.nextLine();

                    System.out.println("Escribe el genero musical del artista: ");
                    String generoMusical = sc.nextLine();

                    System.out.println("Escribe su pais de origen del artista: ");
                    String paisOrigen = sc.nextLine();

                    int idNuevo = 1;

                    String sqlContarID = "SELECT COUNT(*) FROM ARTISTA";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sqlContarID);

                    if (rs.next()) {
                        idNuevo += rs.getInt(1);
                    }

                    Artista artista = new Artista(idNuevo,  nombre, generoMusical, paisOrigen);
                    String sqlInsertarArtista = "INSERT INTO ARTISTA VALUES (?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(sqlInsertarArtista);
                    ps.setInt(1, artista.getId());
                    ps.setString(2, artista.getNombre());
                    ps.setString(3, artista.getGeneroMusical());
                    ps.setString(4, artista.getPaisOrigen());
                    ps.executeUpdate();

                    System.out.println("Se ha añadido Artista!");
                    break;
                case 2:
                    System.out.println("Escribe el ID del artista que quieres eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String sqlParaEliminar = "DELETE FROM ARTISTA WHERE ARTISTA.ID = ?";
                    Statement st2 = con.createStatement();
                    st2.executeUpdate(sqlParaEliminar);

                    System.out.println("Se ha eliminado Artista!");
                    break;
                case 3:
                    String sqlParaListar = "SELECT ID, NOMBRE, GENEROMUSICAL, PAISORIGEN FROM ARTISTA";
                    Statement st3 = con.createStatement();
                    ResultSet rs2 = st3.executeQuery(sqlParaListar);
                    while (rs2.next()) {
                        lista.add(new Artista(rs2.getInt("ID"), rs2.getString("NOMBRE"), rs2.getString("GENEROMUSICAL"), rs2.getString("PAISORIGEN")));
                    }

                    for(Artista a : lista){
                        System.out.println(a);
                    }

                    break;
                default:
                    System.out.println("No existe esta opcion!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Los manejos de datos son incorrectos!");
        }
    }

    public static void ManejarConcierto(Scanner sc, int opcion, Connection con) {
        List<Concierto> listaConciertos = new ArrayList<>();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("Escribe el id del artista: ");
                    int artista = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escribe la fecha del concierto: ");
                    String fecha = sc.nextLine();

                    System.out.println("Escribe lugar del concierto: ");
                    String lugar = sc.nextLine();

                    System.out.println("Escribe el precio de entrada: ");
                    int precioEntrada = sc.nextInt();
                    sc.nextLine();

                    int idNuevo = 1;

                    String sqlContarID = "SELECT COUNT(*) FROM CONCIERTO";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sqlContarID);

                    if (rs.next()) {
                        idNuevo += rs.getInt(1);
                    }

                    Concierto concierto = new Concierto(idNuevo, artista, fecha, lugar, precioEntrada);
                    String sqlInsertarConcierto = "INSERT INTO CONCIERTO VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(sqlInsertarConcierto);
                    ps.setInt(1, concierto.getId());
                    ps.setInt(2, concierto.getArtista());
                    ps.setDate(3, Date.valueOf(concierto.getFecha()));
                    ps.setString(4, concierto.getLugar());
                    ps.setInt(5, concierto.getPrecioEntrada());

                    ps.executeUpdate();

                    System.out.println("Se ha añadido Concierto!");
                    break;
                case 2:
                    System.out.println("Escribe el ID del Concierto que quieres eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String sqlParaEliminar = "DELETE FROM CONCIERTO WHERE CONCIERTO.ID = ?";
                    Statement st2 = con.createStatement();
                    st2.executeUpdate(sqlParaEliminar);

                    System.out.println("Se ha eliminado Artista!");
                    break;
                case 3:
                    String sqlParaListar = "SELECT ID, ARTISTA_ID, FECHA, LUGAR, PRECIOENTRADA FROM CONCIERTO";
                    Statement st3 = con.createStatement();
                    ResultSet rs2 = st3.executeQuery(sqlParaListar);
                    while (rs2.next()) {
                        listaConciertos.add(new Concierto(rs2.getInt("ID"), rs2.getInt("ARTISTA_ID"), rs2.getString("FECHA"), rs2.getString("LUGAR"), rs2.getInt("PRECIOENTRADA")));
                    }

                    for(Concierto c : listaConciertos){
                        System.out.println(c);
                    }

                    break;
                default:
                    System.out.println("No existe esta opcion!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Los manejos de datos son incorrectos!");
        }
    }

    public static void ManejarEntrada(Scanner sc, int opcion, Connection con) {
        List<Entrada> listaEntradas = new ArrayList<>();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("Escribe el id de la concierto: ");
                    int concierto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escribe el comprador: ");
                    String comprador = sc.nextLine();

                    System.out.println("Escribe la cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escribe la de fecha de compra: ");
                    String fechaCompra = sc.nextLine();

                    int idNuevo = 1;

                    String sqlContarID = "SELECT COUNT(*) FROM ENTRADA";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sqlContarID);

                    if (rs.next()) {
                        idNuevo += rs.getInt(1);
                    }

                    Entrada entrada  = new Entrada(idNuevo, concierto, comprador, cantidad, fechaCompra);
                    String sqlInsertarConcierto = "INSERT INTO ENTRADA VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(sqlInsertarConcierto);
                    ps.setInt(1, entrada.getId());
                    ps.setInt(2, entrada.getConcierto());
                    ps.setString(3, entrada.getComprador());
                    ps.setInt(4, entrada.getCantidad());
                    ps.setDate(5, Date.valueOf(entrada.getFechaCompra()));

                    ps.executeUpdate();

                    System.out.println("Se ha añadido Entrada!");
                    break;
                case 2:
                    System.out.println("Escribe el ID del Concierto que quieres eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String sqlParaEliminar = "DELETE FROM ENTRADA WHERE ENTRADA.ID = ?";
                    Statement st2 = con.createStatement();
                    st2.executeUpdate(sqlParaEliminar);

                    System.out.println("Se ha eliminado Artista!");
                    break;
                case 3:
                    String sqlParaListar = "SELECT ID, CONCIERTO_ID, COMPRADOR, CANTIDAD, FECHACOMPRA FROM CONCIERTO";
                    Statement st3 = con.createStatement();
                    ResultSet rs2 = st3.executeQuery(sqlParaListar);
                    while (rs2.next()) {
                        listaEntradas.add(new Entrada(rs2.getInt("ID"), rs2.getInt("CONCIERTO_ID"), rs2.getString("COMPRADOR"), rs2.getInt("CANTIDAD"), rs2.getString("FECHACOMPRA")));
                    }

                    for(Entrada e : listaEntradas){
                        System.out.println(e);
                    }

                    break;
                default:
                    System.out.println("No existe esta opcion!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Los manejos de datos son incorrectos!");
        }
    }
}