package be.vdab.keuken.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ArtikelTest {
    private final static BigDecimal VERKOOPPRIJS = BigDecimal.valueOf(200);
    private Artikel artikel1;
    @BeforeEach
    void beforeEach() {
        artikel1 = new Artikel("test", BigDecimal.ONE, VERKOOPPRIJS);
    }
    @Test
    public void verhoogVerkoopPrijs() {
        artikel1.verhoogVerkoopPrijs(BigDecimal.TEN);
        assertThat(artikel1.getVerkoopPrijs()).isEqualByComparingTo(BigDecimal.valueOf(210));
    }
    @Test void verhoogVerkoopPrijsMetNullMislukt() {
        assertThatNullPointerException().isThrownBy(() ->
                artikel1.verhoogVerkoopPrijs(null)); }
    @Test void verhoogVerkoopPrijsMetMet0Mislukt() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                artikel1.verhoogVerkoopPrijs(BigDecimal.ZERO)); }
    @Test void verhoogVerkoopPrijsMetMetNegatieveWaardeMislukt() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                artikel1.verhoogVerkoopPrijs(BigDecimal.valueOf(-1))); }

}