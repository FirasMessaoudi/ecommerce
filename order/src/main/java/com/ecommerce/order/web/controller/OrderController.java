package com.ecommerce.order.web.controller;


import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.web.exceptions.ImpossibleAjouterOrderException;
import com.ecommerce.order.web.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderDao OrdersDao;

    @PostMapping (value = "/Orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order Order){

        Order nouvelleOrder = OrdersDao.save(Order);

        if(nouvelleOrder == null) throw new ImpossibleAjouterOrderException("Impossible d'ajouter cette Order");

        return new ResponseEntity<Order>(Order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/Orders/{id}")
    public Optional<Order> findById(@PathVariable int id){

        Optional<Order> Order = OrdersDao.findById(id);

        if(!Order.isPresent()) throw new OrderNotFoundException("Cette Order n'existe pas");

        return Order;
    }

    /*
    * Permet de mettre à jour une Order existante.
    * save() mettra à jours uniquement les champs renseignés dans l'objet Order reçu. Ainsi dans ce cas, comme le champs date dans "Order" n'est
    * pas renseigné, la date précédemment enregistrée restera en place
    **/
    @PutMapping(value = "/Orders")
    public void updateOrder(@RequestBody Order Order) {

        OrdersDao.save(Order);
    }
}
