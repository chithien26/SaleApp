//package com.lct.SaleApp.dataInit;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lct.SaleApp.entity.Product;
//import com.lct.SaleApp.repository.ProductRepository;
//import com.lct.SaleApp.service.ProductService;
//import jakarta.annotation.Resource;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    private final ProductRepository productRepository;
//    private final ObjectMapper objectMapper;
//
//    public DataInitializer(ProductRepository productRepository, ObjectMapper objectMapper) {
//        this.productRepository = productRepository;
//        this.objectMapper = objectMapper;
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Đọc file JSON từ classpath
//        ClassPathResource resource = new ClassPathResource("data/products.json");
//        // Chuyển đổi nội dung JSON thành mảng Product
//        Product[] productsArray = objectMapper.readValue(resource.getInputStream(), Product[].class);
//        List<Product> products = Arrays.asList(productsArray);
//
//        // Nếu muốn mỗi lần chạy đảm bảo dữ liệu mới, có thể xóa sạch dữ liệu cũ:
//        productRepository.deleteAll();
//
//        // Lưu danh sách sản phẩm vào database
//        productRepository.saveAll(products);
//
//        System.out.println("✅ Dữ liệu sản phẩm đã được chèn từ file JSON.");
//    }
//}
