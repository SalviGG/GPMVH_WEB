package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    public List<TipoDocumento> findAll();
    public void save(TipoDocumento tipoDocumento);
    public TipoDocumento findOne(int id);
    public void delete(TipoDocumento tipoDocumento);
}
