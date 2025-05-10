package store.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Price {
	
	@Column(name = "value", precision = 19, scale = 4)
	private BigDecimal value;
	
	@Column(name = "currency")
	@Enumerated(value = EnumType.STRING)
	private Currency currency;
	
	public Price() {
		
	}

	public Price(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Price other = (Price) obj;
		return currency == other.currency && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return String.format("Price [value=%s, currency=%s]", value, currency);
	}
}
