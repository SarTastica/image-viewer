package software.ulpgc.imageviewer.view;

public interface ImageDisplay {
    void show(software.ulpgc.imageviewer.model.Image image);
    String image();
    void on(Shift shift);

    interface Shift {
        Shift Null = offset -> {};
        void offset(int offset);
    }
}
