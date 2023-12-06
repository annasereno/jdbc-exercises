package dao;
import com.mysql.cj.jdbc.Driver;
import config.Config;
import models.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAlbumsDAO {

    // initialize the connection to null so we know whether or not to close it when done
    private Connection connection = null;


    public void createConnection() throws MySQLAlbumsException {
        System.out.print("Trying to connect... ");
        try {
            //TODO: create the connection and assign it to the instance variable
            // register driver
            DriverManager.registerDriver(new Driver());

            // establish connection
            connection = DriverManager.getConnection(
                    Config.getURL(),
                    Config.getUser(),
                    Config.getPassword()
            );
            System.out.println("connection created.");
        } catch (SQLException e) {
            throw new MySQLAlbumsException("connection failed!!!");
        }
    };


    public int getTotalAlbums() throws MySQLAlbumsException {
        int count = 0;
        try {
            //TODO: fetch the total number of albums from the albums table and assign it to the local variable
            Statement statement = connection.createStatement();


            /// OPTION 1: RETRIEVE THE  COUNT FROM THE DB  ///
            ResultSet albumsRS = statement.executeQuery("SELECT count(*) FROM albums");
            albumsRS.next();
            // resultSet get... methods accept either a column name or a column index
            count = albumsRS.getInt("COUNT(*)");


           /// OPTION 2: RETRIEVE ALL ALBUMS, LOOP OVER, AND INCREMENT COUNT ///
//            ResultSet albumsRS = statement.executeQuery("SELECT * FROM albums");
//            while (albumsRS.next()){
//                count ++;
//            };
        } catch (SQLException e) {
            throw new MySQLAlbumsException("Error executing query: " + e.getMessage() + "!!!");
        }
        return count;
    }


    public void closeConnection (){
        if(connection == null) {
            System.out.println("Connection aborted.");
            return;
        }
        try {
            //TODO: close the connection
            connection.close();
            System.out.println("Connection closed.");
        } catch(SQLException e) {
            // ignore this
        }
    };


//    public List<Album> fetchAlbums() throws MySQLAlbumsException {
//        List<Album> albums = new ArrayList<>();
//
//        // TODO: write your code here
//        try {
//            PreparedStatement = connection.createStatement("SELECT * FROM albums");
//            statement.executeQuery();
//        } catch (SQLException e){
//            throw new MySQLAlbumsException (e.getMessage());
//        }
//        return albums;
//    };


//    private Album makeAlbumFromDB(ResultSet record) throws MySQLAlbumsException {
//      // assumes that record parameter is pointing to a valid record
//      Album album = new Album();
//      try {
//          album.setId(record.getLong("id"));
//          album.setArtist(record.getString("artist"));
//          album.setName(record.getString("name"));
//          album.setReleaseDate(record.getInt("release_date"));
//          album.setGenre(record.getString("genre"));
//          album.setSales(record.getInt("sales"));
//
//      };
//    };

        public Album fetchAlbumById(long id) {
        Album album = null;

        // TODO: write your code here
        try{
//            String sql = "SELECT * FROM albums WHERE id = ?";
//            String searchTermWithWildcards = "%" + searchTerm + "%";
            PreparedStatement st = connection.prepareStatement("SELECT * FROM albums WHERE id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();


        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return album;
    }

    // Note that insertAlbum should return the id that MySQL creates for the new inserted album record
    public long insertAlbum(Album album) throws MySQLAlbumsException {
        long id = 0;

        // TODO: write your code here

        return id;
    }

    public void updateAlbum(Album album) throws MySQLAlbumsException {

        // TODO: write your code here

    }

    public void deleteAlbumById(long id) throws MySQLAlbumsException {

        // TODO: write your code here

    }


}
