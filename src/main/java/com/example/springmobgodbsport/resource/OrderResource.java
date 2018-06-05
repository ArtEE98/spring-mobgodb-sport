package com.example.springmobgodbsport.resource;

import com.example.springmobgodbsport.document.Order;
import com.example.springmobgodbsport.document.Requirements;
import com.example.springmobgodbsport.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("orders")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Order order) {
        orderRepository.save(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}")
    public Optional<Order> read(@PathVariable Integer id) {
        return orderRepository.findById(id);
    }

    private int getMaxId() {
        List<Order> sortOrders = orderRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        if (sortOrders.size() == 0)
            return 0;
        return sortOrders.get(0).getId();
    }

    @GetMapping("/generate")
    public String Generate() {
        final Random random = new Random();
        final String[] organizations = new String[]{"Club", "Luxoft", "SmartSport", "NetCracker"};

        int minNumberOfNewOrders = 20;
        int maxNumberOfNewOrders = 100;


        Faker faker = new Faker();
        Set<String> names = new HashSet<>();

        //Generate unique names.
        for (int i = 0; i < minNumberOfNewOrders + random.nextInt(maxNumberOfNewOrders - minNumberOfNewOrders); i++) {
            names.add(faker.name().firstName());
        }

        //Get unique names depending of existed.
        Set<String> existingNames = getNames();
        for (String n : names) {
            if (existingNames.contains(n))
                names.remove(n);
        }

        int nextId = getMaxId() + 1;
        for (String n : names) {

            boolean trainings = random.nextBoolean();
            boolean sauna = random.nextBoolean();

            boolean gym = random.nextBoolean();

            Integer numberOfTrainingsSession = random.nextInt(25);
            Requirements requirements = new Requirements(trainings, sauna, gym, numberOfTrainingsSession);

            String organization = organizations[random.nextInt(organizations.length)];
            Integer numberOfAthlets = random.nextInt(30);
            String country = faker.address().country();
            String status = random.nextBoolean() ? "pending" : "done";
            orderRepository.save(new Order(nextId, n, organization, numberOfAthlets, country, status, requirements));
            nextId++;
        }
        return "Orders were generated";
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Set<String> getNames() {
        List<Order> orders = orderRepository.findAll();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < orders.size(); i++) {
            result.add(orders.get(i).getManagerName());
        }
        return result;
    }

}
