package dao;

import models.Qoute;

import java.util.List;

public class QuotesTest {

    public static void main(String[] args) {
        MySQLQuotesDAO quotesDAO = new MySQLQuotesDAO();
        quotesDAO.createConnection();
        List<Qoute> quotesFromDB = quotesDAO.getQuotes();
        for (Qoute quote : quotesFromDB) {
            System.out.println();
            System.out.println(quote.getAuthor() + " said:");
            System.out.println(quote.getContent());
        }
        quotesDAO.closeConnection();
    }

}
