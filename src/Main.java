public class Main {
    public static void main(String[] args) throws InterruptedException {
        Brain brain = new Brain();

        System.out.println("The fight begins");

        while (true) {
            Thread.sleep(4000);
            System.out.println("Hit on head");
            brain.hitOnHead();
            Thread.sleep(5000);
            System.out.println("Hit on eyes");
            brain.hitOnEyes();
            Thread.sleep(1000);
            System.out.println("Hit on stomach");
            brain.hitOnStomach();
        }
    }
}
