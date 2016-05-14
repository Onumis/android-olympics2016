class Api::AthletesController < Api::BaseController

  def index
    render json: Athlete.all, status: 200
  end

  def show
    render json: Athlete.find(params[:id]), status: 200
  end

end
