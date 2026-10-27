package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    @Test 
    public void happyPath(){
        TorpedoStore store=new TorpedoStore(10);
        assertEquals(10, store.getTorpedoCount());
    }
    @Test
    void constructor_WithZeroCount_StoreIsEmpty() {
        TorpedoStore store = new TorpedoStore(0);

        assertTrue(store.isEmpty());
    }
    @Test
    void fire_ValidAmountWithZeroFailureRate_SucceedsAndDecrementsCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(3);

        assertTrue(result);
        assertEquals(7, store.getTorpedoCount());
    }
    @Test
    void fire_WithMaxFailureRate_FailsAndCountRemainsUnchanged() {
        TorpedoStore store = new TorpedoStore(10, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(10, store.getTorpedoCount());
    }
    @Test
    void fire_ZeroTorpedos_ThrowsIllegalArgumentException() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
        assertEquals(10, store.getTorpedoCount());
    }
}
