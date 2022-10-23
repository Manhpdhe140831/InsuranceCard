import { useState } from 'react';
import '../styles/createCustomer.scss';
import {
  BsFillPersonFill,
  BsFillCalendarEventFill,
  BsFillTelephoneFill,
  BsEnvelopeFill,
  BsFillPeopleFill,
  BsGenderAmbiguous,
  BsGeoAltFill,
  BsShieldLockFill,
} from "react-icons/bs";

const GMale = 'male';
const GFemale = 'female';
const CreateCus = () => {
  const [accountCus, setAccountCus] = useState({
    username: "",
    password: "",
  });

  const [profileCus, setProfileCus] = useState({
    name: '',
    gender: '',
    birthday: '',
    folk: '',
    phone: '',
    email: '',
  });
  const [addressCus, setAddressCus] = useState({
    country: '',
    city: '',
    district: '',
    street: '',
  });
  const handleGetUserName = (user) => {
    setAccountCus({ ...accountCus, username: user });
  };

  return (
    <div>
      <div className="container-create-Cus">
        <div className="main-create-Cus">
          <h1>Create Customer</h1>
          <div className="Account">
            <h2>Account</h2>
            <h4>
              <BsFillPersonFill className="icon" />
              Username:{" "}
              <input
                placeholder="enter username"
                value={accountCus.username}
                onChange={(e) => {
                  setAccountCus({
                    ...accountCus,
                    username: e.target.value,
                  });
                }}
              />
            </h4>
            <h4>
              <BsShieldLockFill className="icon" /> Password:{" "}
              <input
                type="password"
                value={accountCus.password}
                placeholder="enter password"
                onChange={(e) => {
                  setAccountCus({
                    ...accountCus,
                    password: e.target.value,
                  });
                }}
              />
            </h4>
          </div>
          <div className="Profile">
            <h2>Profile</h2>
            <div className="flex-container-profile">
              <div className="left-profile flex-profile">
                <h4>
                  <BsFillPersonFill className="icon" /> Name:{' '}
                  <input
                    placeholder="enter name"
                    value={profileCus.name}
                    onChange={(e) => {
                      setProfileCus({
                        ...profileCus,
                        name: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsFillPeopleFill className="input" /> Folk:{" "}
                  <input
                    placeholder="enter folk"
                    value={profileCus.folk}
                    onChange={(e) => {
                      setProfileCus({
                        ...profileCus,
                        folk: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsGenderAmbiguous className="icon" /> Gender: <br />
                </h4>
                <input
                  type="radio"
                  name="gender"
                  onChange={(e) => {
                    setProfileCus({ ...profileCus, gender: GMale });
                  }}
                />{' '}
                MALE
                <input
                  type="radio"
                  name="gender"
                  onChange={(e) => {
                    setProfileCus({ ...profileCus, gender: GFemale });
                  }}
                />{' '}
                FEMALE
              </div>
              <div className="right-profile flex-profile">
                <h4>
                  <BsFillCalendarEventFill className="icon" /> Birthday:{' '}
                  <input
                    type="date"
                    value={profileCus.birthday}
                    onChange={(e) => {
                      setProfileCus({
                        ...profileCus,
                        birthday: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsFillTelephoneFill className="icon" /> Phone:{' '}
                  <input
                    type="number"
                    placeholder="enter phone number"
                    value={profileCus.phone}
                    onChange={(e) => {
                      setProfileCus({
                        ...profileCus,
                        phone: parseInt(e.target.value),
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsEnvelopeFill className="icon" /> Email:{' '}
                  <input
                    type="email"
                    placeholder="enter email"
                    value={profileCus.email}
                    onChange={(e) => {
                      setProfileCus({
                        ...profileCus,
                        email: e.target.value,
                      });
                    }}
                  />
                </h4>
              </div>
            </div>
          </div>
          <div className="Address">
            <h2>Addresss</h2>
            <h4>
              <BsGeoAltFill className="icon" /> Country:{' '}
              <input
                placeholder="enter country"
                value={addressCus.country}
                onChange={(e) => {
                  setAddressCus({ ...addressCus, country: e.target.value });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> City:{' '}
              <input
                placeholder="enter city"
                value={addressCus.city}
                onChange={(e) => {
                  setAddressCus({ ...addressCus, city: e.target.value });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> District:{' '}
              <input
                placeholder="enter district "
                value={addressCus.district}
                onChange={(e) => {
                  setAddressCus({
                    ...addressCus,
                    district: e.target.value,
                  });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> Street:{' '}
              <input
                placeholder="enter street"
                value={addressCus.street}
                onChange={(e) => {
                  setAddressCus({ ...addressCus, street: e.target.value });
                }}
              />
            </h4>
          </div>
          <div className="btn-create-Cus">
            <button>Create</button>
            <button>Cancel</button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default CreateCus;

