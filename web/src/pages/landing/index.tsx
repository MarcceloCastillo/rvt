import { Link } from 'react-router-dom';
import { FiArrowRight } from 'react-icons/fi';

import './styles.css'

import { assets } from "../../assets";

export const Landing = () => {
  return (
    <div id="page-landing">
    <div className="content-wrapper">
      <img src={assets.IMG_LOGO} alt="RVT" />

      <main>
        <h1>Busque um mundo mais orgânico</h1>
        <p>Encontre a horta comunitária mais proxima de você.</p>
      </main>

      <div className="location">
        <strong>São Paulo</strong>
      </div>

      <Link to="/app" className="enter-app">
        <FiArrowRight size={26} color="rgba(0, 0, 0, 0.6)" />
      </Link>
    </div>
  </div>
  )
}