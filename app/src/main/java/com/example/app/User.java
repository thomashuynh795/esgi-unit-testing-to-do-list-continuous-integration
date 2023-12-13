package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    private String email;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String password;

    public boolean isEmailValid() {
        return email != null && Pattern.compile("^[^@]+@[^@]+\\.[^@]+$").matcher(this.email).matches();
    }

    public boolean isPasswordValid() {
        if (this.password == null || this.password.length() < 8 || 40 < this.password.length())
            return false;

        Boolean hasUpperCase = false;
        Boolean hasLowerCase = false;
        Boolean hasDigit = false;

        char[] passwordAsCharArray = this.password.toCharArray();

        for (int i = 0; i < passwordAsCharArray.length; i++) {
            if (Character.isUpperCase(passwordAsCharArray[i]))
                hasUpperCase = true;
            if (Character.isLowerCase(passwordAsCharArray[i]))
                hasLowerCase = true;
            if (Character.isDigit(passwordAsCharArray[i]))
                hasDigit = true;
        }

        return hasUpperCase && hasLowerCase && hasDigit;

    }

    public boolean isThirteenYearsOld() {
        return 13 <= Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    public boolean isFirstnameValid() {
        return this.firstname != null && !this.firstname.trim().isEmpty();
    }

    public boolean isLastNameValid() {
        return this.lastname != null && !this.lastname.trim().isEmpty();
    }

    public boolean isBirthdateValid() {
        if (this.birthdate == null) {
            return false;
        }
        return birthdate.isBefore(LocalDate.now());
    }

    public boolean isValid() {
        return isEmailValid()
                && isFirstnameValid()
                && isLastNameValid()
                && isBirthdateValid()
                && isPasswordValid()
                && isThirteenYearsOld();
    }

    public boolean isValidWithExternalApi() {
        return this.isEmailValid() && isFirstnameValid() && isLastNameValid() && isBirthdateValid();
    }
}
