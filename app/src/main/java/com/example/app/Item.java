package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Item {

    private String name;
    private String content;
    LocalDateTime addDate;

    public boolean contentIsValid() {
        if (this.content.length() > 1000) {
            return false;
        }
        return true;
    }

}
