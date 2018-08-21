public class Brain {
    private Head head = new Head();
    private Stomach stomach = new Stomach();
    private Eyes eyes = new Eyes();

    public void hitOnHead() {
        head.onPain();
    }

    public void hitOnEyes() {
        eyes.onPain();
    }

    public void hitOnStomach() {
        stomach.onPain();
    }
}
