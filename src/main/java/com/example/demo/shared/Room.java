package com.example.demo.shared;

public enum Room {

        ROOM_101("ROOM_101"),
        ROOM_102("ROOM_102"),
        ROOM_103("ROOM_103"),
        ROOM_104("ROOM_104"),
        ROOM_105("ROOM_105");

        private final String value;

        Room(String value) {
                this.value = value;
        }

        public String getValue() {
                return value;
        }
}