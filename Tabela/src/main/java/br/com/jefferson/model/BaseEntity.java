package br.com.jefferson.model;

import org.hibernate.proxy.HibernateProxyHelper;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> {

    public abstract T getSeq();
    public abstract void setSeq(T seq);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        if (getSeq() == null || ((BaseEntity<?>) obj).getSeq() == null) {
            return false;
        }
        if (!getSeq().equals(((BaseEntity<?>) obj).getSeq())) {
            return false;
        }
        if (!HibernateProxyHelper.getClassWithoutInitializingProxy(obj)
                .isAssignableFrom(this.getClass())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getSeq() == null ? super.hashCode() : getSeq().hashCode();
    }



}
