package entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemPedido.class)
public abstract class ItemPedido_ {

	public static volatile SingularAttribute<ItemPedido, Long> id;
	public static volatile SingularAttribute<ItemPedido, Produto> produto;
	public static volatile SingularAttribute<ItemPedido, Integer> quantidade;
	public static volatile SingularAttribute<ItemPedido, Pedido> pedido;

}

