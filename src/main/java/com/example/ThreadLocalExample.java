package com.example;

public class ThreadLocalExample {

    private static class Context {

        private final String _userName;

        private Context(String userName) {
            _userName = userName;
        }

        public String getUserName() {
            return _userName;
        }
    }
}
