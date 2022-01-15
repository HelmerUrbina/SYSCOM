package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Entity
@Table(name = "SINTE_TIPO_OPERACION")
@Data
public class BeanTipoOperacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NTIPO_OPERACION_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "VTIPO_OPERACION_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VTIPO_OPERACION_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
