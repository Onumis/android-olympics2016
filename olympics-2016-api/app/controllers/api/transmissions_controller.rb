class Api::TransmissionsController < Api::BaseController

  def index
    render json: Transmission.all, status: 200
  end

end
