package org.launchcode.javawebdevtechjobsauthentication.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;


    @Entity
    public class User extends AbstractEntity {

        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        public User() {}
        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }
        public boolean isMatchingPassword(String password) {
            return encoder.matches(password, pwHash);
        }
        public String getUsername() {
            return username;
        }

    }

