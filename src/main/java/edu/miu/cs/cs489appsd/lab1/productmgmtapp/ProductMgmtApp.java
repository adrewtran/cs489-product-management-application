package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product(new BigInteger("31288741190182539912"), "Banana", LocalDate.parse("2025-01-24"), 124, new BigDecimal("0.55")),
            new Product(new BigInteger("29274582650152771644"), "Apple", LocalDate.parse("2024-12-09"), 18, new BigDecimal("1.09")),
            new Product(new BigInteger("91899274600128155167"), "Carrot", LocalDate.parse("2025-03-31"), 89, new BigDecimal("2.99")),
            new Product(new BigInteger("31288741190182539913"), "Banana", LocalDate.parse("2025-02-13"), 240, new BigDecimal("0.65"))
        };
        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        List<Product> sorted = Arrays.stream(products)
            .sorted(Comparator.comparing(Product::getName)
                .thenComparing(Product::getUnitPrice, Comparator.reverseOrder()))
            .toList();

        // JSON format
        System.out.println("\nJSON Format:");
        System.out.println("[");
        for (int i = 0; i < sorted.size(); i++) {
            Product p = sorted.get(i);
            System.out.printf("  {\"productId\":%s,\"name\":\"%s\",\"dateSupplied\":\"%s\",\"quantityInStock\":%d,\"unitPrice\":%.2f}%s\n",
                p.getProductId().toString(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice(),
                (i < sorted.size() - 1 ? "," : ""));
        }
        System.out.println("]");

        // XML format
        System.out.println("\nXML Format:");
        System.out.println("<products>");
        for (Product p : sorted) {
            System.out.printf("  <product>\n    <productId>%s</productId>\n    <name>%s</name>\n    <dateSupplied>%s</dateSupplied>\n    <quantityInStock>%d</quantityInStock>\n    <unitPrice>%.2f</unitPrice>\n  </product>\n",
                p.getProductId().toString(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
        System.out.println("</products>");

        // CSV format
        System.out.println("\nCSV Format:");
        System.out.println("Product Id,Name,Date Supplied,Quantity In Stock,Unit Price");
        for (Product p : sorted) {
            System.out.printf("%s,%s,%s,%d,%.2f\n",
                p.getProductId().toString(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
    }
}
