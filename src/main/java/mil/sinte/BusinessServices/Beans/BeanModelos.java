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
@Table(name = "SINTE_MARCAS_MODELOS")
@Data
public class BeanModelos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NMARCA_MODELO_CODIGO", nullable = false)
    private String modelo;

    @Column(name = "NMARCA_CODIGO", nullable = false)
    private String marca;

    @Column(name = "VMARCA_MODELO_DESCRIPCION")
    private String descripcion;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
