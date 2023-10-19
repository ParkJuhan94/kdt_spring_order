package org.prgrms.kdt.domain.voucher;

import java.util.UUID;
import org.prgrms.kdt.domain.voucher.Voucher;

public class FixedAmountVoucher implements Voucher {

    private final UUID voucherId;
    private final long amount;

    public FixedAmountVoucher(UUID voucherId, long amount) {
        this.voucherId = voucherId;
        this.amount = amount;
    }

    @Override
    public UUID getVoucherId() {
        return null;
    }

    public long discount(long beforeDiscount) {
        return beforeDiscount - amount;
    }
}
