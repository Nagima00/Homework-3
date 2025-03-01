import java.util.ArrayList;
import java.util.List;

public class MUDGame {
    // Cloneable Interface
    interface CloneableGameEntity {
        CloneableGameEntity cloneEntity();
    }

    // Room Class
    static class Room implements CloneableGameEntity {
        private final String description;

        public Room(String description) {
            this.description = description;
        }

        @Override
        public Room cloneEntity() {
            return new Room(this.description);
        }

        @Override
        public String toString() {
            return "Room: " + description;
        }
    }

    // NPC Class
    static class NPC implements CloneableGameEntity {
        private final String name;

        public NPC(String name) {
            this.name = name;
        }

        @Override
        public NPC cloneEntity() {
            return new NPC(this.name);
        }

        @Override
        public String toString() {
            return "NPC: " + name;
        }
    }

    // Dungeon Class
    static class Dungeon {
        private final String name;
        private final List<Room> rooms;
        private final List<NPC> npcs;

        public Dungeon(String name, List<Room> rooms, List<NPC> npcs) {
            this.name = name;
            this.rooms = rooms;
            this.npcs = npcs;
        }

        public void showDungeonInfo() {
            System.out.println("Dungeon: " + name);
            System.out.println("Rooms: " + rooms.size());
            System.out.println("NPCs: " + npcs.size());
        }
    }

    // Dungeon Builder Interface
    interface IDungeonBuilder {
        IDungeonBuilder setDungeonName(String name);
        IDungeonBuilder addRoom(Room room);
        IDungeonBuilder addNPC(NPC npc);
        Dungeon build();
    }

    // Simple Dungeon Builder
    static class SimpleDungeonBuilder implements IDungeonBuilder {
        private String name;
        private List<Room> rooms = new ArrayList<>();
        private List<NPC> npcs = new ArrayList<>();

        @Override
        public IDungeonBuilder setDungeonName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public IDungeonBuilder addRoom(Room room) {
            rooms.add(room);
            return this;
        }

        @Override
        public IDungeonBuilder addNPC(NPC npc) {
            npcs.add(npc);
            return this;
        }

        @Override
        public Dungeon build() {
            return new Dungeon(name, rooms, npcs);
        }
    }

    // Main Method (Demo)
    public static void main(String[] args) {
        // Using Builder Pattern
        Dungeon dungeon = new SimpleDungeonBuilder()
                .setDungeonName("Dark Cave")
                .addRoom(new Room("Entrance Hall"))
                .addRoom(new Room("Treasure Chamber"))
                .addNPC(new NPC("Goblin King"))
                .build();

        dungeon.showDungeonInfo();

        // Using Prototype Pattern
        Room originalRoom = new Room("Dark Chamber");
        Room clonedRoom = originalRoom.cloneEntity();

        NPC originalNPC = new NPC("Skeleton Warrior");
        NPC clonedNPC = originalNPC.cloneEntity();

        System.out.println("Original Room: " + originalRoom);
        System.out.println("Cloned Room: " + clonedRoom);
        System.out.println("Original NPC: " + originalNPC);
        System.out.println("Cloned NPC: " + clonedNPC);
    }
}
