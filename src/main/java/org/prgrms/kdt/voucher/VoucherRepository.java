package org.prgrms.kdt.voucher;

import java.util.Optional;
import java.util.UUID;
import org.prgrms.kdt.voucher.Voucher;

public interface VoucherRepository {

    Voucher insert(Voucher voucher);

    Optional<Voucher> findById(UUID voucherId);
}
