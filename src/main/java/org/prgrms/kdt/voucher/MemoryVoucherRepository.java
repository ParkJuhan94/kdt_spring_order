package org.prgrms.kdt.voucher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
@Qualifier("memory")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MemoryVoucherRepository implements VoucherRepository , InitializingBean, DisposableBean {

    private final Map<UUID, Voucher> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(storage.get(voucherId));
    }

    @Override
    public Voucher insert(Voucher voucher) {
        storage.put(voucher.getVoucherId(), voucher);
        return voucher;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct called!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy called!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called!");
    }
}
