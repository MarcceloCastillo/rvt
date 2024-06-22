import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { FiPlus, FiArrowRight } from "react-icons/fi";

import { Marker, Popup } from 'react-leaflet';

import { assets } from "../../assets";
import { markerIcon } from "../../utils/maps";

import { Map } from "../../components/map";

import './styles.css';

import { allCommunityGarden, CommunityGardenInfo } from "../../services/community-garden";


export const CommunityGardenMap = () => {
  const [communityGarden, setCommunityGarden] = useState<CommunityGardenInfo[]>([]);

  useEffect(() => {
    allCommunityGarden()
      .then((response) => setCommunityGarden(response))
  }, []);

  return (
    <div id="page-map">
      <aside>
        <header>
          <img src={assets.IMG_LOGO} alt="RVT" />

          <h2>Escolha uma horta no mapa</h2>
          <p>Ajude a comunidade local e tenha uma alimentação mais saudável :)</p>
        </header>

        <footer>
          <strong>São Paulo</strong>
        </footer>
      </aside>

      <Map>
        {communityGarden.map(({ id, name, latitude, longitude }) => (
          <Marker
            key={id}
            position={[latitude, longitude]}
            icon={markerIcon()}
          >
            <Popup
              closeButton={false}
              minWidth={240}
              maxWidth={240}
              className="map-popup"
            >
              {name}
              <Link to={`/community-garden/${id}`}>
                <FiArrowRight size={20} color="#fff" />
              </Link>
            </Popup>
          </Marker>
        ))}
      </Map>

      <Link to="/community-garden/create" className="create-community-garden">
        <FiPlus size={32} color="#fff" />
      </Link>
    </div>
  )
}