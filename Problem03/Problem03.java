import com.sun.source.tree.Tree;

import java.util.*;

public class Problem03 {
    static class Person {
        String name;
        int sent;
        int received;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSent() {
            return sent;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }

        public int getReceived() {
            return received;
        }

        public void setReceived(int received) {
            this.received = received;
        }

        public Person(String name, int sent, int received) {
            this.name = name;
            this.sent = sent;
            this.received = received;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        TreeMap<String, Person> phonebook = new TreeMap<>();

        while (!command.equals("Statistics")) {
            String[] split = command.split("=");
            String token = split[0];
            switch (token) {
                case "Add":
                    String username = split[1];
                    int sent = Integer.parseInt(split[2]);
                    int received = Integer.parseInt(split[3]);
                    if (!phonebook.containsKey(username)) {
                        Person person = new Person(username, sent, received);
                        phonebook.put(username, person);
                    }
                    break;
                case "Message":
                    String sender = split[1];
                    String receiver = split[2];
                    if (phonebook.containsKey(sender) && phonebook.containsKey(receiver)) {
                        phonebook.get(sender).setSent(phonebook.get(sender).getSent() + 1);
                        phonebook.get(receiver).setReceived(phonebook.get(receiver).getReceived() + 1);
                        if ((phonebook.get(sender).getSent() + phonebook.get(sender).getReceived()) >= capacity) {
                            System.out.println(sender + " reached the capacity!");
                            phonebook.remove(sender);
                        }
                        if ((phonebook.get(receiver).getReceived() + phonebook.get(receiver).getSent()) >= capacity) {
                            System.out.println(receiver + " reached the capacity!");
                            phonebook.remove(receiver);
                        }
                    }
                    break;
                case "Empty":
                    username = split[1];
                    if (username.equals("All")) {
                        phonebook.clear();
                    } else {
                        phonebook.remove(username);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Users count: " + phonebook.size());
        phonebook.entrySet()
                .stream()
                .sorted((a, b) -> ((b.getValue().getReceived() - a.getValue().getReceived())))
                .forEach(e -> System.out.println(e.getKey() + " - " + (e.getValue().getReceived() + e.getValue().getSent())));

    }
}
