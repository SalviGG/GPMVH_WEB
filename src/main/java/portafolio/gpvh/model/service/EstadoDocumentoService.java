package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.EstadoDocumento;
import java.util.List;

public interface EstadoDocumentoService {

    public List<EstadoDocumento>findAll();
    public void save(EstadoDocumento estadoDocumento);
    public EstadoDocumento findOne(int id);
    public void delete(EstadoDocumento estadoDocumento);
}
