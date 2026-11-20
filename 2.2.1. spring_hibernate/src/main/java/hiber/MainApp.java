package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Maxim", "Beldyaev", "max@gmail.com");
      User user2 = new User("Dante", "SpardaSon", "devilMayCry@gmail.com");
      User user3 = new User("Kazuya", "Mishima", "kingOfIronFist@gmail.com");
      User user4 = new User("Ivan", "Ivanov", "abramovich@gmail.com");

      user1.setCar(new Car("Ford", 13));
      user2.setCar(new Car("BMV", 5));
      user3.setCar(new Car("Mercedes", 12));
      user4.setCar(new Car("Ferrari", 21));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();

      System.out.println("======================================================");

      for (User user : users) {
         System.out.println(user);
      }

      System.out.println("======================================================");

      System.out.println("\u001B[32m" + "Владелец: " + userService.getUserByCar( "Mercedes", 12));

      context.close();
   }
}
