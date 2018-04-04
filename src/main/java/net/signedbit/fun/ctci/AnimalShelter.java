package net.signedbit.fun.ctci;

import java.util.Iterator;

import static net.signedbit.fun.ctci.AnimalShelter.Animal.CAT;
import static net.signedbit.fun.ctci.AnimalShelter.Animal.DOG;

public class AnimalShelter {
    public enum Animal {
        DOG, CAT
    }

    private final MyLinkedList<Animal> list = new MyLinkedList<>();

    public void enqueue(final Animal animal) {
        list.append(animal);
    }

    public Animal dequeueAny() {
        return list.remove(0);
    }

    public Animal dequeueDog() {
        return dequeue(DOG);
    }

    public Animal dequeueCat() {
        return dequeue(CAT);
    }

    private Animal dequeue(final Animal desired) {
        final Iterator<Animal> it = list.iterator();
        for (int i = 0; it.hasNext(); i++) {
            final Animal animal = it.next();
            if (animal == desired) {
                list.remove(i);
                return animal;
            }
        }
        return null;
    }
}
