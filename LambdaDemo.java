/**
 * Lambdas - how to use them?
 */

public class LambdaDemo {

    // Run point
    public static void main(String[] args) {

        // Execute piece of code in thread, use lambda instead of Runnable class-implementor
        Runnable runnable = () -> {for (int i = 0; i < 5; i++) System.out.println("I'm threading...");};
        Thread thread = new Thread(runnable);
        thread.run();

        // Listener with anonymous class
        MyListener myListenerOldStyle = new MyListener(new MyEvent() {
            @Override
            public void fire() {
                System.out.println("Fired up in old style!");
            }
        });
        myListenerOldStyle.triggerEvent();
        // Listener with lambda instead of anonymous class
        MyListener myListenerLambdaStyle =
                new MyListener(() -> System.out.println("Fired up in lambda style!"));
        myListenerLambdaStyle.triggerEvent();
    }

    interface MyEvent {
        void fire();
    }

    static class MyListener {
        MyEvent event;

        public MyListener(MyEvent event) {
            this.event = event;
        }

        private void triggerEvent() {
            event.fire();
        }
    }

}
