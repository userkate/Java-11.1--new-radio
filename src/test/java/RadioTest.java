import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    public void currentStation() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void maxStation() {
        Radio radio = new Radio(10, 0, 10, 100, 0, 5);
        radio.setMaxStation(10);
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void aboveLimitStation() {
        Radio radio = new Radio(10, 0, 11, 100, 0, 5);
        radio.setCurrentStation(11);
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void minStation() {
        Radio radio = new Radio(10, 0, 0, 100, 0, 5);
        radio.setMinStation(0);
        assertEquals(0, radio.getMinStation());
    }

    @Test
    public void underLimitStation() {
        Radio radio = new Radio(10, 0, -1, 100, 0, 5);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getMinStation());
    }

    @Test
    public void nextStation() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void aboveNextStation() {
        Radio radio = new Radio(10, 0, 10, 100, 0, 5);
        radio.nextStation();
        assertEquals(0, radio.getMinStation());
    }

    @Test
    public void prevStation() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.pressPrevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void underMinStation() {
        Radio radio = new Radio(10, 0, 0, 100, 0, 5);
        radio.pressPrevStation();
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void currentVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.setCurrentVolume(5);
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void aboveLimitVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 101);
        radio.setCurrentVolume(100);
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void underLimitVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, -1);
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void maxVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.setMaxVolume(100);
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void minVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.setMinVolume(0);
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void plusVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.plusVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    public void plusAboveLimitVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 100);
        radio.plusVolume();
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void minusVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 5);
        radio.minusVolume();
        assertEquals(4, radio.getCurrentVolume());
    }

    @Test
    public void minusUnderLimitVolume() {
        Radio radio = new Radio(10, 0, 5, 100, 0, 0);
        radio.minusVolume();
        assertEquals(0, radio.getMinVolume());
    }
}
