package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.dataAccess.JbdcProductDao;
import oopWithNLayeredApp.entities.Product;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product("IPhone Xr", 1,10000);

        Logger[] loggers = {new DatabaseLogger(),new FileLogger(),new MailLogger()};

        ProductManager productManager = new ProductManager(new HibernateProductDao(), List.of(loggers));
        productManager.add(product1);

    }
}