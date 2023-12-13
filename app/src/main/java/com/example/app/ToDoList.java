package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
@Setter

public class ToDoList {

    Item listItem[];
    int indexItem = 0;
    final int nbItem = 10;
    User creator;

    public ToDoList(User user) {
        setCreator(user);
        this.listItem = new Item[nbItem];

    }

    public void add(Item item) throws ArithmeticException {

        if (indexItem < nbItem) {
            if (isNameValid(item)) {
                if (indexItem > 0) {
                    if (30 < ChronoUnit.MINUTES.between(listItem[indexItem - 1].getAddDate(), LocalDate.now())) {
                        throw new ArithmeticException("You added something less than 30 minute ago");
                    }
                }
                if (indexItem == 7) {
                    EmailSenderService.sendEmail(getCreator());
                }
                item.setAddDate(LocalDateTime.now());
                listItem[indexItem] = item;
                indexItem++;
                save();
            } else
                throw new ArithmeticException("Incorrect item name");
        } else
            throw new ArithmeticException("You have reached the items limit number");

    }

    public boolean isNameValid(Item item) {

        for (int i = 0; i < indexItem; i++) {
            if (item.getName() == listItem[i].getName()) {
                return false;
            }
        }
        return true;
    }

    public void save() {
        throw new ArithmeticException("There is a problem with the database");
    }

}
