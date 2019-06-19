package com.menu.crud;

import com.menu.entity.Dish;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DishService {
    public EntityManager em = Persistence.createEntityManagerFactory("menu").createEntityManager();

    public Dish add(Dish dish){
        em.getTransaction().begin();
        Dish dishFromDB = em.merge(dish);
        em.getTransaction().commit();
        return dishFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Dish get(long id){
        return em.find(Dish.class, id);
    }

    public void update(Dish dish){
        em.getTransaction().begin();
        em.merge(dish);
        em.getTransaction().commit();
    }

    public List<Dish> getAll(){
        TypedQuery<Dish> namedQuery = em.createNamedQuery("Dish.getAll", Dish.class);
        return namedQuery.getResultList();
    }
}
