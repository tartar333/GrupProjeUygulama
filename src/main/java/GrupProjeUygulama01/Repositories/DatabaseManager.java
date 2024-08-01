package GrupProjeUygulama01.Repositories;

import GrupProjeUygulama01.Repositories.entities.Urun;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager<T extends Urun> implements ICRUD<T> {
    
    private ArrayList<T> urunList = new ArrayList<>();
    
    @Override
    public T save(T t) {
        if (urunList.add(t)) {
            return t;
        } else {
            return null;
        }
    }
    
    @Override
    public List<T> saveAll(List<T> t) {
        if (urunList.addAll(t)) {
            return t;
        } else {
            return null;
        }
    }
    
    @Override
    public T update(T t) {
        int index = urunList.indexOf(t);
        if (index >= 0) {
            return urunList.set(index, t);
        } else {
            return null;
        }
    }
    
    @Override
    public List<T> getAll() {
        if (urunList.isEmpty()) {
            System.out.println("There is no data saved to this list");
        } else {
            for (T t : urunList) {
                System.out.println(t);
            }
        }
        return urunList;
    }
    
    @Override
    public T findByID(int id) {
        for (T member : urunList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }
    
    public ArrayList<T> getUrunList() {
        return urunList;
    }
}